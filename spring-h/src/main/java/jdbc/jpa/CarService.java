package jdbc.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarService {
    @Autowired
    private CarDao carDao;

    @Transactional
    public void insert(){
    	carDao.insert();
    	int i = 1/0;
    	System.out.println(i);
    }
}

