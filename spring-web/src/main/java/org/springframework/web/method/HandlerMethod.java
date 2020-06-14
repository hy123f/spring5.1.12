/*
 * Copyright 2002-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.web.method;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.core.BridgeMethodResolver;
import org.springframework.core.GenericTypeResolver;
import org.springframework.core.MethodParameter;
import org.springframework.core.ResolvableType;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.SynthesizingMethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Encapsulates information about a handler method consisting of a
 * {@linkplain #getMethod() method} and a {@linkplain #getBean() bean}.
 * Provides convenient access to method parameters, the method return value,
 * method annotations, etc.
 *
 * <p>The class may be created with a bean instance or with a bean name
 * (e.g. lazy-init bean, prototype bean). Use {@link #createWithResolvedBean()}
 * to obtain a {@code HandlerMethod} instance with a bean instance resolved
 * through the associated {@link BeanFactory}.
 *
 * @author Arjen Poutsma
 * @author Rossen Stoyanchev
 * @author Juergen Hoeller
 * @author Sam Brannen
 * @since 3.1
 */
public class HandlerMethod {

	/** Logger that is available to subclasses. */
	protected final Log logger = LogFactory.getLog(getClass());
	//// 虽然Object类型，但是注册handlerMethod时候构造的时候有可能传入的是一个String类型的bean name   com.action.CarController@41d58085  cglib代理生成的。
	private final Object bean; //可能是cglib代理生成

	@Nullable
	private final BeanFactory beanFactory; // org.springframework.beans.factory.support.DefaultListableBeanFactory@5dcacad7: defining beans [org.springframework.context.annotation.internalConfigurationAnnotationProcessor,org.springframework.context.annotation.internalAutowiredAnnotationProcessor,org.springframework.context.annotation.internalCommonAnnotationProcessor,org.springframework.context.event.internalEventListenerProcessor,org.springframework.context.event.internalEventListenerFactory,hyfBootApplication,org.springframework.boot.autoconfigure.internalCachingMetadataReaderFactory,carController,repositoryController,profileController,alpsController,repositorySchemaController,repositoryPropertyReferenceController,repositoryEntityController,repositorySearchController,org.springframework.boot.autoconfigure.AutoConfigurationPackages,org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration,org.springframework.boot.autoconfigure.condition.BeanTypeRegistry,propertySourcesPlaceholderConfigurer,org.springframework.boot.autoconfigure.websocket.servlet.WebSocketServletAutoConfiguration$TomcatWebSocketConfiguration,websocketServletWebServerCustomizer,org.springframework.boot.autoconfigure.websocket.servlet.WebSocketServletAutoConfiguration,org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryConfiguration$EmbeddedTomcat,tomcatServletWebServerFactory,org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration,servletWebServerFactoryCustomizer,tomcatServletWebServerFactoryCustomizer,server-org.springframework.boot.autoconfigure.web.ServerProperties,org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor,org.springframework.boot.context.properties.ConfigurationBeanFactoryMetadata,webServerFactoryCustomizerBeanPostProcessor,errorPageRegistrarBeanPostProcessor,org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration$DispatcherServletConfiguration,dispatcherServlet,spring.http-org.springframework.boot.autoconfigure.http.HttpProperties,spring.mvc-org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties,org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration$DispatcherServletRegistrationConfiguration,dispatcherServletRegistration,org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration,org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration,taskExecutorBuilder,applicationTaskExecutor,spring.task.execution-org.springframework.boot.autoconfigure.task.TaskExecutionProperties,org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration,defaultValidator,methodValidationPostProcessor,org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration$WhitelabelErrorViewConfiguration,error,beanNameViewResolver,org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration$DefaultErrorViewResolverConfiguration,conventionErrorViewResolver,org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration,errorAttributes,basicErrorController,errorPageCustomizer,preserveErrorControllerTargetClassPostProcessor,spring.resources-org.springframework.boot.autoconfigure.web.ResourceProperties,org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$WebMvcAutoConfigurationAdapter$FaviconConfiguration,faviconHandlerMapping,faviconRequestHandler,org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$EnableWebMvcConfiguration,requestMappingHandlerAdapter,requestMappingHandlerMapping,mvcConversionService,mvcValidator,mvcContentNegotiationManager,mvcPathMatcher,mvcUrlPathHelper,viewControllerHandlerMapping,beanNameHandlerMapping,resourceHandlerMapping,mvcResourceUrlProvider,defaultServletHandlerMapping,mvcUriComponentsContributor,httpRequestHandlerAdapter,simpleControllerHandlerAdapter,handlerExceptionResolver,mvcViewResolver,mvcHandlerMappingIntrospector,org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration$WebMvcAutoConfigurationAdapter,defaultViewResolver,viewResolver,welcomePageHandlerMapping,requestContextFilter,org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration,hiddenHttpMethodFilter,formContentFilter,org.springframework.boot.autoconfigure.jdbc.DataSourceConfiguration$Generic,dataSource,org.springframework.boot.autoconfigure.jdbc.DataSourceJmxConfiguration$Hikari,org.springframework.boot.autoconfigure.jdbc.DataSourceJmxConfiguration,org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration$PooledDataSourceConfiguration,org.springframework.boot.autoconfigure.jdbc.metadata.DataSourcePoolMetadataProvidersConfiguration$HikariPoolDataSourceMetadataProviderConfiguration,hikariPoolDataSourceMetadataProvider,org.springframework.boot.autoconfigure.jdbc.metadata.DataSourcePoolMetadataProvidersConfiguration,org.springframework.boot.autoconfigure.jdbc.DataSourceInitializerInvoker,org.springframework.boot.autoconfigure.jdbc.DataSourceInitializationConfiguration,dataSourceInitializerPostProcessor,org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration,spring.datasource-org.springframework.boot.autoconfigure.jdbc.DataSourceProperties,tk.mybatis.mapper.autoconfigure.MapperAutoConfiguration$MapperScannerRegistrarNotFoundConfiguration,tk.mybatis.mapper.autoconfigure.MapperAutoConfiguration,sqlSessionFactory,sqlSessionTemplate,mybatis-tk.mybatis.mapper.autoconfigure.MybatisProperties,org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration$MapperScannerRegistrarNotFoundConfiguration,org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration,mybatis-org.mybatis.spring.boot.autoconfigure.MybatisProperties,org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration,mbeanExporter,objectNamingStrategy,mbeanServer,org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration$RabbitConnectionFactoryCreator,rabbitConnectionFactory,org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration$RabbitTemplateConfiguration,rabbitTemplate,amqpAdmin,org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration$MessagingTemplateConfiguration,rabbitMessagingTemplate,org.springframework.amqp.rabbit.annotation.RabbitBootstrapConfiguration,org.springframework.amqp.rabbit.config.internalRabbitListenerAnnotationProcessor,org.springframework.amqp.rabbit.config.internalRabbitListenerEndpointRegistry,org.springframework.boot.autoconfigure.amqp.RabbitAnnotationDrivenConfiguration$EnableRabbitConfiguration,org.springframework.boot.autoconfigure.amqp.RabbitAnnotationDrivenConfiguration,simpleRabbitListenerContainerFactoryConfigurer,rabbitListenerContainerFactory,directRabbitListenerContainerFactoryConfigurer,org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration,spring.rabbitmq-org.springframework.boot.autoconfigure.amqp.RabbitProperties,org.springframework.boot.autoconfigure.data.redis.LettuceConnectionConfiguration,lettuceClientResources,redisConnectionFactory,org.springframework.boot.autoconfigure.data.redis.JedisConnectionConfiguration,org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration,redisTemplate,stringRedisTemplate,spring.redis-org.springframework.boot.autoconfigure.data.redis.RedisProperties,org.springframework.boot.autoconfigure.context.ConfigurationPropertiesAutoConfiguration,org.springframework.boot.autoconfigure.dao.PersistenceExceptionTranslationAutoConfiguration,persistenceExceptionTranslationPostProcessor,org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration,mongo,spring.data.mongodb-org.springframework.boot.autoconfigure.mongo.MongoProperties,org.springframework.boot.autoconfigure.data.mongo.MongoDataConfiguration,mongoMappingContext,mongoCustomConversions,org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration,mongoDbFactory,mongoTemplate,mappingMongoConverter,gridFsTemplate,org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration,org.springframework.boot.autoconfigure.data.redis.RedisReactiveAutoConfiguration,reactiveRedisTemplate,org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration,keyValueMappingContext,redisCustomConversions,redisReferenceResolver,redisConverter,redisKeyValueAdapter,redisKeyValueTemplate,org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$Jackson2ObjectMapperBuilderCustomizerConfiguration,standardJacksonObjectMapperBuilderCustomizer,spring.jackson-org.springframework.boot.autoconfigure.jackson.JacksonProperties,org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$JacksonObjectMapperBuilderConfiguration,jacksonObjectMapperBuilder,org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$ParameterNamesModuleConfiguration,parameterNamesModule,org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$JacksonObjectMapperConfiguration,jacksonObjectMapper,org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration,jsonComponentModule,org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration$StringHttpMessageConverterConfiguration,stringHttpMessageConverter,org.springframework.boot.autoconfigure.http.JacksonHttpMessageConvertersConfiguration$MappingJackson2HttpMessageConverterConfiguration,mappingJackson2HttpMessageConverter,org.springframework.boot.autoconfigure.http.JacksonHttpMessageConvertersConfiguration,org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration,messageConverters,org.springframework.hateoas.config.EntityLinksConfiguration,entityLinksPluginRegistry,delegatingEntityLinks,controllerEntityLinks,controllerLinkBuilderFactoryBean,org.springframework.hateoas.config.HateoasConfiguration,linkRelationMessageSource,jackson2ModuleRegisteringBeanPostProcessor,defaultRelProvider,annotationRelProvider,_relProvider,relProviderPluginRegistry,linkDiscoverers,linkDiscovererRegistry,org.springframework.data.web.c...

	private final Class<?> beanType;  //class com.action.CarController  // 方法所属类

	private final Method method; //public com.action.Result com.action.CarController.selectByPrimaryKey(java.lang.Long)

	private final Method bridgedMethod;  //public com.action.Result com.action.CarController.selectByPrimaryKey(java.lang.Long)  // 被桥接的方法,如果method是原生的，这个属性的值就是method	

	private final MethodParameter[] parameters;  //参数

	@Nullable
	private HttpStatus responseStatus; // Http状态码

	@Nullable
	private String responseStatusReason;  // ResponseStatus注解的reason值

	@Nullable
	private HandlerMethod resolvedFromHandlerMethod;

	@Nullable
	private volatile List<Annotation[][]> interfaceParameterAnnotations;


	/**
	 * Create an instance from a bean instance and a method.
	 */
	public HandlerMethod(Object bean, Method method) {
		Assert.notNull(bean, "Bean is required");
		Assert.notNull(method, "Method is required");
		this.bean = bean;
		this.beanFactory = null;
		this.beanType = ClassUtils.getUserClass(bean);
		this.method = method;
		this.bridgedMethod = BridgeMethodResolver.findBridgedMethod(method);
		this.parameters = initMethodParameters();
		evaluateResponseStatus();
	}

	/**
	 * Create an instance from a bean instance, method name, and parameter types.
	 * @throws NoSuchMethodException when the method cannot be found
	 */
	public HandlerMethod(Object bean, String methodName, Class<?>... parameterTypes) throws NoSuchMethodException {
		Assert.notNull(bean, "Bean is required");
		Assert.notNull(methodName, "Method name is required");
		this.bean = bean;
		this.beanFactory = null;
		this.beanType = ClassUtils.getUserClass(bean);
		this.method = bean.getClass().getMethod(methodName, parameterTypes);
		this.bridgedMethod = BridgeMethodResolver.findBridgedMethod(this.method);
		this.parameters = initMethodParameters();
		evaluateResponseStatus();
	}

	/**
	 * Create an instance from a bean name, a method, and a {@code BeanFactory}.
	 * The method {@link #createWithResolvedBean()} may be used later to
	 * re-create the {@code HandlerMethod} with an initialized bean.
	 */
	public HandlerMethod(String beanName, BeanFactory beanFactory, Method method) {
		Assert.hasText(beanName, "Bean name is required");
		Assert.notNull(beanFactory, "BeanFactory is required");
		Assert.notNull(method, "Method is required");
		this.bean = beanName;
		this.beanFactory = beanFactory;
		Class<?> beanType = beanFactory.getType(beanName);
		if (beanType == null) {
			throw new IllegalStateException("Cannot resolve bean type for bean with name '" + beanName + "'");
		}
		this.beanType = ClassUtils.getUserClass(beanType);
		this.method = method;
		this.bridgedMethod = BridgeMethodResolver.findBridgedMethod(method);
		this.parameters = initMethodParameters();
		evaluateResponseStatus();
	}

	/**
	 * Copy constructor for use in subclasses.
	 */
	protected HandlerMethod(HandlerMethod handlerMethod) {
		Assert.notNull(handlerMethod, "HandlerMethod is required");
		this.bean = handlerMethod.bean;
		this.beanFactory = handlerMethod.beanFactory;
		this.beanType = handlerMethod.beanType;
		this.method = handlerMethod.method;
		this.bridgedMethod = handlerMethod.bridgedMethod;
		this.parameters = handlerMethod.parameters;
		this.responseStatus = handlerMethod.responseStatus;
		this.responseStatusReason = handlerMethod.responseStatusReason;
		this.resolvedFromHandlerMethod = handlerMethod.resolvedFromHandlerMethod;
	}

	/**
	 * Re-create HandlerMethod with the resolved handler.
	 */
	private HandlerMethod(HandlerMethod handlerMethod, Object handler) {
		Assert.notNull(handlerMethod, "HandlerMethod is required");
		Assert.notNull(handler, "Handler object is required");
		this.bean = handler;
		this.beanFactory = handlerMethod.beanFactory;
		this.beanType = handlerMethod.beanType;
		this.method = handlerMethod.method;
		this.bridgedMethod = handlerMethod.bridgedMethod;
		this.parameters = handlerMethod.parameters;
		this.responseStatus = handlerMethod.responseStatus;
		this.responseStatusReason = handlerMethod.responseStatusReason;
		this.resolvedFromHandlerMethod = handlerMethod;
	}

	private MethodParameter[] initMethodParameters() {
		int count = this.bridgedMethod.getParameterCount();
		MethodParameter[] result = new MethodParameter[count];
		for (int i = 0; i < count; i++) {
			HandlerMethodParameter parameter = new HandlerMethodParameter(i);
			GenericTypeResolver.resolveParameterType(parameter, this.beanType);
			result[i] = parameter;
		}
		return result;
	}

	private void evaluateResponseStatus() {
		ResponseStatus annotation = getMethodAnnotation(ResponseStatus.class);
		if (annotation == null) {
			annotation = AnnotatedElementUtils.findMergedAnnotation(getBeanType(), ResponseStatus.class);
		}
		if (annotation != null) {
			this.responseStatus = annotation.code();
			this.responseStatusReason = annotation.reason();
		}
	}


	/**
	 * Return the bean for this handler method.
	 */
	public Object getBean() {
		return this.bean;
	}

	/**
	 * Return the method for this handler method.
	 */
	public Method getMethod() {
		return this.method;
	}

	/**
	 * This method returns the type of the handler for this handler method.
	 * <p>Note that if the bean type is a CGLIB-generated class, the original
	 * user-defined class is returned.
	 */
	public Class<?> getBeanType() {
		return this.beanType;
	}

	/**
	 * If the bean method is a bridge method, this method returns the bridged
	 * (user-defined) method. Otherwise it returns the same method as {@link #getMethod()}.
	 */
	protected Method getBridgedMethod() {
		return this.bridgedMethod;
	}

	/**
	 * Return the method parameters for this handler method.
	 */
	public MethodParameter[] getMethodParameters() {
		return this.parameters;
	}

	/**
	 * Return the specified response status, if any.
	 * @since 4.3.8
	 * @see ResponseStatus#code()
	 */
	@Nullable
	protected HttpStatus getResponseStatus() {
		return this.responseStatus;
	}

	/**
	 * Return the associated response status reason, if any.
	 * @since 4.3.8
	 * @see ResponseStatus#reason()
	 */
	@Nullable
	protected String getResponseStatusReason() {
		return this.responseStatusReason;
	}

	/**
	 * Return the HandlerMethod return type.
	 */
	public MethodParameter getReturnType() {
		return new HandlerMethodParameter(-1);
	}

	/**
	 * Return the actual return value type.
	 */
	public MethodParameter getReturnValueType(@Nullable Object returnValue) {
		return new ReturnValueMethodParameter(returnValue);
	}

	/**
	 * Return {@code true} if the method return type is void, {@code false} otherwise.
	 */
	public boolean isVoid() {
		return Void.TYPE.equals(getReturnType().getParameterType());
	}

	/**
	 * Return a single annotation on the underlying method traversing its super methods
	 * if no annotation can be found on the given method itself.
	 * <p>Also supports <em>merged</em> composed annotations with attribute
	 * overrides as of Spring Framework 4.2.2.
	 * @param annotationType the type of annotation to introspect the method for
	 * @return the annotation, or {@code null} if none found
	 * @see AnnotatedElementUtils#findMergedAnnotation
	 */
	@Nullable
	public <A extends Annotation> A getMethodAnnotation(Class<A> annotationType) {
		return AnnotatedElementUtils.findMergedAnnotation(this.method, annotationType);
	}

	/**
	 * Return whether the parameter is declared with the given annotation type.
	 * @param annotationType the annotation type to look for
	 * @since 4.3
	 * @see AnnotatedElementUtils#hasAnnotation
	 */
	public <A extends Annotation> boolean hasMethodAnnotation(Class<A> annotationType) {
		return AnnotatedElementUtils.hasAnnotation(this.method, annotationType);
	}

	/**
	 * Return the HandlerMethod from which this HandlerMethod instance was
	 * resolved via {@link #createWithResolvedBean()}.
	 */
	@Nullable
	public HandlerMethod getResolvedFromHandlerMethod() {
		return this.resolvedFromHandlerMethod;
	}

	/** // 从工厂中取得beans ，放入
	 * If the provided instance contains a bean name rather than an object instance,
	 * the bean name is resolved before a {@link HandlerMethod} is created and returned.
	 */
	public HandlerMethod createWithResolvedBean() {
		Object handler = this.bean;
		if (this.bean instanceof String) {
			Assert.state(this.beanFactory != null, "Cannot resolve bean name without BeanFactory");
			String beanName = (String) this.bean;
			handler = this.beanFactory.getBean(beanName);
		}
		return new HandlerMethod(this, handler);
	}

	/**
	 * Return a short representation of this handler method for log message purposes.
	 * @since 4.3
	 */
	public String getShortLogMessage() {
		return getBeanType().getName() + "#" + this.method.getName() +
				"[" + this.method.getParameterCount() + " args]";
	}


	private List<Annotation[][]> getInterfaceParameterAnnotations() {
		List<Annotation[][]> parameterAnnotations = this.interfaceParameterAnnotations;
		if (parameterAnnotations == null) {
			parameterAnnotations = new ArrayList<>();
			for (Class<?> ifc : this.method.getDeclaringClass().getInterfaces()) {
				for (Method candidate : ifc.getMethods()) {
					if (isOverrideFor(candidate)) {
						parameterAnnotations.add(candidate.getParameterAnnotations());
					}
				}
			}
			this.interfaceParameterAnnotations = parameterAnnotations;
		}
		return parameterAnnotations;
	}

	private boolean isOverrideFor(Method candidate) {
		if (!candidate.getName().equals(this.method.getName()) ||
				candidate.getParameterCount() != this.method.getParameterCount()) {
			return false;
		}
		Class<?>[] paramTypes = this.method.getParameterTypes();
		if (Arrays.equals(candidate.getParameterTypes(), paramTypes)) {
			return true;
		}
		for (int i = 0; i < paramTypes.length; i++) {
			if (paramTypes[i] !=
					ResolvableType.forMethodParameter(candidate, i, this.method.getDeclaringClass()).resolve()) {
				return false;
			}
		}
		return true;
	}


	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof HandlerMethod)) {
			return false;
		}
		HandlerMethod otherMethod = (HandlerMethod) other;
		return (this.bean.equals(otherMethod.bean) && this.method.equals(otherMethod.method));
	}

	@Override
	public int hashCode() {
		return (this.bean.hashCode() * 31 + this.method.hashCode());
	}

	@Override
	public String toString() {
		return this.method.toGenericString();
	}


	// Support methods for use in "InvocableHandlerMethod" sub-class variants..

	@Nullable
	protected static Object findProvidedArgument(MethodParameter parameter, @Nullable Object... providedArgs) {
		if (!ObjectUtils.isEmpty(providedArgs)) {
			for (Object providedArg : providedArgs) {
				if (parameter.getParameterType().isInstance(providedArg)) {
					return providedArg;
				}
			}
		}
		return null;
	}

	protected static String formatArgumentError(MethodParameter param, String message) {
		return "Could not resolve parameter [" + param.getParameterIndex() + "] in " +
				param.getExecutable().toGenericString() + (StringUtils.hasText(message) ? ": " + message : "");
	}

	/**
	 * Assert that the target bean class is an instance of the class where the given
	 * method is declared. In some cases the actual controller instance at request-
	 * processing time may be a JDK dynamic proxy (lazy initialization, prototype
	 * beans, and others). {@code @Controller}'s that require proxying should prefer
	 * class-based proxy mechanisms.
	 */
	protected void assertTargetBean(Method method, Object targetBean, Object[] args) {
		Class<?> methodDeclaringClass = method.getDeclaringClass();
		Class<?> targetBeanClass = targetBean.getClass();
		if (!methodDeclaringClass.isAssignableFrom(targetBeanClass)) {
			String text = "The mapped handler method class '" + methodDeclaringClass.getName() +
					"' is not an instance of the actual controller bean class '" +
					targetBeanClass.getName() + "'. If the controller requires proxying " +
					"(e.g. due to @Transactional), please use class-based proxying.";
			throw new IllegalStateException(formatInvokeError(text, args));
		}
	}

	protected String formatInvokeError(String text, Object[] args) {
		String formattedArgs = IntStream.range(0, args.length)
				.mapToObj(i -> (args[i] != null ?
						"[" + i + "] [type=" + args[i].getClass().getName() + "] [value=" + args[i] + "]" :
						"[" + i + "] [null]"))
				.collect(Collectors.joining(",\n", " ", " "));
		return text + "\n" +
				"Controller [" + getBeanType().getName() + "]\n" +
				"Method [" + getBridgedMethod().toGenericString() + "] " +
				"with argument values:\n" + formattedArgs;
	}


	/**
	 * A MethodParameter with HandlerMethod-specific behavior.
	 */
	protected class HandlerMethodParameter extends SynthesizingMethodParameter {

		@Nullable
		private volatile Annotation[] combinedAnnotations;

		public HandlerMethodParameter(int index) {
			super(HandlerMethod.this.bridgedMethod, index);
		}

		protected HandlerMethodParameter(HandlerMethodParameter original) {
			super(original);
		}

		@Override
		public Class<?> getContainingClass() {
			return HandlerMethod.this.getBeanType();
		}

		@Override
		public <T extends Annotation> T getMethodAnnotation(Class<T> annotationType) {
			return HandlerMethod.this.getMethodAnnotation(annotationType);
		}

		@Override
		public <T extends Annotation> boolean hasMethodAnnotation(Class<T> annotationType) {
			return HandlerMethod.this.hasMethodAnnotation(annotationType);
		}

		@Override
		public Annotation[] getParameterAnnotations() {
			Annotation[] anns = this.combinedAnnotations;
			if (anns == null) {
				anns = super.getParameterAnnotations();
				int index = getParameterIndex();
				if (index >= 0) {
					for (Annotation[][] ifcAnns : getInterfaceParameterAnnotations()) {
						if (index < ifcAnns.length) {
							Annotation[] paramAnns = ifcAnns[index];
							if (paramAnns.length > 0) {
								List<Annotation> merged = new ArrayList<>(anns.length + paramAnns.length);
								merged.addAll(Arrays.asList(anns));
								for (Annotation paramAnn : paramAnns) {
									boolean existingType = false;
									for (Annotation ann : anns) {
										if (ann.annotationType() == paramAnn.annotationType()) {
											existingType = true;
											break;
										}
									}
									if (!existingType) {
										merged.add(adaptAnnotation(paramAnn));
									}
								}
								anns = merged.toArray(new Annotation[0]);
							}
						}
					}
				}
				this.combinedAnnotations = anns;
			}
			return anns;
		}

		@Override
		public HandlerMethodParameter clone() {
			return new HandlerMethodParameter(this);
		}
	}


	/**
	 * A MethodParameter for a HandlerMethod return type based on an actual return value.
	 */
	private class ReturnValueMethodParameter extends HandlerMethodParameter {

		@Nullable
		private final Object returnValue;

		public ReturnValueMethodParameter(@Nullable Object returnValue) {
			super(-1);
			this.returnValue = returnValue;
		}

		protected ReturnValueMethodParameter(ReturnValueMethodParameter original) {
			super(original);
			this.returnValue = original.returnValue;
		}

		@Override
		public Class<?> getParameterType() {
			return (this.returnValue != null ? this.returnValue.getClass() : super.getParameterType());
		}

		@Override
		public ReturnValueMethodParameter clone() {
			return new ReturnValueMethodParameter(this);
		}
	}

}
