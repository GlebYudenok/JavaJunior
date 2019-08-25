package by.gyudenok.dao.impl;

import by.gyudenok.dao.DAO;
import by.gyudenok.domain.Role;
import by.gyudenok.domain.User;
import by.gyudenok.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FileUserDAO implements DAO<User> {

    //fix later
    private static final String filePath = "src\\main\\resources\\users";
    private static final Logger LOGGER = LogManager.getLogger(FileUserDAO.class);

    private File file = new File(filePath);
    private FileWriter fr = null;

    @Override
    public void create(User user) throws IOException {
        try {
            fr = new FileWriter(file,true);
            fr.write(user.getUserId() +
                    " " + user.getName() +
                    " " + user.getSurname() +
                    " " + user.getEmail() +
                    " ");
            for(int i = 0; i < user.getPhones().size(); i++){
                fr.write(user.getPhones().get(i) + " ");
            }
            for(int i = 0; i < user.getRoles().size(); i++){
                fr.write(user.getRoles().get(i) + " ");
            }
            fr.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        LOGGER.info("User was created successfully!");
    }

    @Override
    public User read(int id) throws IOException, DAOException {
        int size = Files.readAllLines(Paths.get(filePath)).size();
        if (id > size) {
            throw new IllegalArgumentException();
        } else if (size < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }

        String s = Files.readAllLines(Paths.get(filePath)).get(id);
        s = s.trim();
        List<String> sss = Arrays.asList(s.split(" "));
        User user = new User();
        user.setUserId(Integer.valueOf(sss.get(0)));
        user.setName(sss.get(1));
        user.setSurname(sss.get(2));
        user.setEmail(sss.get(3));
        int i = 4;
        ArrayList<String> arr = new ArrayList();
        while (sss.get(i).startsWith("375")){
            arr.add(sss.get(i));
            i++;
        }
        user.setPhones(arr);

        ArrayList<Role> roles = new ArrayList<>();
        while (i < sss.size()){
            try {
                roles.add(Role.valueOf(sss.get(i)));
            }catch (IllegalArgumentException e){
                throw new DAOException();
            }
            i++;
        }
        user.setRoles(roles);
        LOGGER.info("User was received successfully!");
        return user;
    }

    @Override
    public List<User> readAll() throws IOException, DAOException {
        int i = Files.readAllLines(Paths.get(filePath)).size();
        List<User> userList = new ArrayList<>();
        for(int j = 0; j < i; j++){
            try {
                userList.add(read(j));
            } catch (DAOException e) {
                throw new DAOException();
            }
        }
        return userList;
    }

    @Override
    public void update(User user, int id) throws IOException {
        List<String> raws = new LinkedList<>();
        raws = Files.readAllLines(Paths.get(filePath));

        raws.set(id, formatForFile(user));

        fr = new FileWriter(file);
        raws.forEach(str -> {
            try {
                fr.write(str + "\n");
            } catch (IOException e) {
                LOGGER.error("The file does not exist or it contains incorrect data!");
            }
        });
        fr.close();
    }

    @Override
    public void deleteByIndex(int index) throws IOException {
        List<String> raws = Files.readAllLines(Paths.get(filePath));
        raws.remove(index);
        fr = new FileWriter(file);
        raws.forEach(str -> {
            try {
                fr.write(str + "\n");
            } catch (IOException e) {
                LOGGER.error("The file does not exist or it contains incorrect data!");
            }
        });
        fr.close();
    }

    @Override
    public void deleteById(int id) throws IOException {
        List<String> stringList = Files.readAllLines(Paths.get(filePath));
        for(int i = 0; i < stringList.size(); i++){
            List<String> l = Arrays.asList(
                    stringList.get(i).split(" "));
            if(Integer.valueOf(l.get(0)) == id){
                stringList.remove(i);
            }
        }

        fr = new FileWriter(file);
        stringList.forEach(str -> {
            try {
                fr.write(str + "\n");
            } catch (IOException e) {
                LOGGER.error("The file does not exist or it contains incorrect data!");
            }
        });
        fr.close();
    }

    private String formatForFile(User user){
        String s = user.getUserId() + " " +
                user.getName() + " " + user.getSurname() +
                " " + user.getEmail() + " ";

        for(int i = 0; i < user.getPhones().size(); i++){
            s += user.getPhones().get(i) + " ";
        }

        for(int i = 0; i < user.getRoles().size(); i++){
            s += user.getRoles().get(i) + " ";
        }
        s.trim();
        return s;
    }
}
