package com.ani.testing.service;
import org.springframework.stereotype.Service;
import com.ani.testing.domain.App;
import com.ani.testing.repository.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.Date;
import java.util.List;

@Service
public class AppService {
    @Autowired
    private AppRepository repository;

    public List<App> finAppsBetween(Date st, Date ed) {
        return  repository.findByPubDtBetween(st, ed);
    }
}
