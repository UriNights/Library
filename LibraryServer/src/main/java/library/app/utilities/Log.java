package library.app.utilities;

import java.io.FileWriter;
import java.io.IOException;

public class Log {

	public static void addUser(String nick) {

		try (FileWriter writer = new FileWriter("log")) {
			writer.write(nick);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteUser(String nick) {

		try (FileWriter writer = new FileWriter("log")) {
			writer.write(nick);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
