package org.example.designPatterns.factoryDesignPattern;

import java.util.Map;
import java.util.function.Supplier;
enum DBType{
    MYSQL,MONGODB,POSTGRES
}
public interface DataBaseConnectionPool {
    void useDB();
}
class MySQL implements DataBaseConnectionPool{
    @Override
    public void useDB(){
        System.out.println("Using MySQL DB... ");
    }
}
class PostgreSQL implements DataBaseConnectionPool{
    @Override
    public void useDB(){
        System.out.println("Using PostgreSQL DB...");
    }
}
class MongoDB implements DataBaseConnectionPool{
    @Override
    public void useDB(){
        System.out.println("Using NOSQL DB - MongoDB...");
    }
}
class DBFactory{
   private static final Map<DBType, Supplier<DataBaseConnectionPool>> dbServices = Map.of(
           DBType.MYSQL,MySQL::new,
           DBType.MONGODB,MongoDB::new,
           DBType.POSTGRES,PostgreSQL::new
   );
   public static DataBaseConnectionPool createDBConnection(DBType type){
       return dbServices.getOrDefault(type,
               ()-> {
           throw new IllegalArgumentException("Invalid DB option");
       }
       ).get();
   }
}
class TestDBConnectionPool{
    public static void main(String[] args) {
        DataBaseConnectionPool db = DBFactory.createDBConnection(DBType.MYSQL);
        db.useDB();
    }
}