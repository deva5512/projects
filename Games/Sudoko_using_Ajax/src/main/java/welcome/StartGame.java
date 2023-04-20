package welcome;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@WebServlet("/startgame")
public class StartGame extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException {
		FileReader file = new FileReader("C:\\deva\\JS\\BASICS\\sudoko\\sudoko.json");

		try {
			JSONParser parse = new JSONParser();
			Object obj = parse.parse(file);
			JSONObject object = (JSONObject) obj;
			JSONArray arr = (JSONArray) object.get("puzzles");
			int num = (int) (Math.random() * 9);
			PrintWriter out = response.getWriter();
			out.print(arr.get(num));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
