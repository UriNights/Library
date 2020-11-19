package library.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import library.RelationDBConfig;

@SpringBootApplication
public class LibraryApplication {

    @Autowired
    private RelationDBConfig relationaDBConfig;
    
	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}
}
