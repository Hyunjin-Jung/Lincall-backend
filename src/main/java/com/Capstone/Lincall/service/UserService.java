package com.Capstone.Lincall.service;

import com.Capstone.Lincall.domain.User;
import com.Capstone.Lincall.mapper.ClientMapper;
import com.Capstone.Lincall.mapper.CounselorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    ClientMapper clientMapper;
    CounselorMapper counselorMapper;

    @Autowired
    UserService(ClientMapper clientMapper, CounselorMapper counselorMapper){
        this.clientMapper = clientMapper;
        this.counselorMapper = counselorMapper;
    }

    public User getClient(String id){
        return clientMapper.findByID(id);
    }

    public User getCounselor(String id){
        return counselorMapper.findByID(id);
    }

    public boolean clientSignUp(User user){
        try{
            clientMapper.save(user);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public User clientLogIn(String id, String pw){
        User user = clientMapper.findByID(id);
        if(user == null) return null;
        if(user.getPassword().equals(pw)) return user;
        return null;
    }

    public boolean clientIdAvailable(String id){
        User user = clientMapper.findByID(id);
        if(user == null) return true; // 사용 가능
        else return false;  // 사용 불가
    }

    public boolean counselorSignUp(User user){
        try{
            counselorMapper.save(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public User counselorLogIn(String id, String pw){
        User user = counselorMapper.findByID(id);
        if(user == null) return null;
        if(user.getPassword().equals(pw)) return user;
        return null;
    }

    public boolean counselorIdAvailable(String id){
        User user = counselorMapper.findByID(id);
        if(user == null) return true; // 사용 가능
        else return false;  // 사용 불가
    }
}
