package practice;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;



public class JsonFile {

	@Test
	public void jsonfile() throws IOException, ParseException {
//		JSONParser p=new JSONParser();
//		Object obj = p.parse(new FileReader("./src/test/resources/filejson.json"));
//		JSONObject map=(JSONObject)obj;
//		System.out.println(map.get("un"));
		
		JSONParser js = new JSONParser();
		Object obj = js.parse(new FileReader("./src/test/resources/demoData.json"));
		JSONObject map = (JSONObject) obj;
		System.out.println(map.get("url"));
		Object s1 = map.get("un");
		System.out.println(s1);
	}

}                               
