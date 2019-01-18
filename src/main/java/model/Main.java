package model;

import datalayer.MysqlConnector;

public class Main {

    public static void main(String[] args){

        if(MysqlConnector.getInstance().connect() != null){
            System.out.println("connectie !");
        } else {
            System.out.println("failed to create a database connection...");
        }

    }
}
