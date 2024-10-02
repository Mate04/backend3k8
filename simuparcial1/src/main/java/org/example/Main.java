package org.example;

import org.example.entities.Repository;
import org.example.entities.Tag;
import org.example.entities.User;
import org.example.repositories.RepositoryRepositoryImp;
import org.example.repositories.TagRepositoryImp;
import org.example.repositories.UserRepositoryImp;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        try(
                InputStream is = Main.class.getResourceAsStream("/files/REPOSITORIES.txt");
                Scanner scanner = new Scanner(is);
                ){

            if (scanner.hasNextLine()){
                scanner.nextLine();
            }

            while (scanner.hasNextLine()){
                String linea = scanner.nextLine();
                String[] campos = linea.split("\\|",-1);

            }


        }catch (Exception e){
            e.printStackTrace();
        }
    */
        UserRepositoryImp userRepository = new UserRepositoryImp();
        RepositoryRepositoryImp repositoryRepositoryImp = new RepositoryRepositoryImp();
        TagRepositoryImp tagRepositoryImp = new TagRepositoryImp();
        List<User> rep = userRepository.findAll();




    }
}