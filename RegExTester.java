/**
 * <p>This work is distributed under The MIT License (MIT)
 * Copyright (c)  2014 Rizwan Tanoli
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.</p>
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

/**
 * <p>As the name applies tests a regex expression against text specified in a file. Each<br/>
 * line in the file is tested against the regex and the result is outputted to console.</p>
 * <p>Way to run: javac RegExTester regex_expression file_to_apply_regex_against.</p>
 * @author rizwan.tanoli
 *
 */
public class RegExTester {

	public static void main(String...args) {
		
		if (args == null) {
			System.out.println("Sorry but this program was run in an invalid manner.");
			System.out.println("The correct way to run the program is: java RegExTester your_regular_expression file_to_apply_the_expression_to");
			return;
		}
		
		if (args.length < 2) {
			System.out.println("Sorry but this program was run in an invalid manner.");
			System.out.println("The correct way to run the program is: java RegExTester your_regular_expression file_to_apply_the_expression_to");
			return;
		}
		
		Pattern pattern = Pattern.compile(args[0]);
		
		try {
			String line = null;
			InputStream is = new FileInputStream(args[1]);
			InputStreamReader file = new InputStreamReader(is);
			BufferedReader reader = new BufferedReader(file);
			
			System.out.println("Regex Begin applied: "+args[0]);
			
			while ((line = reader.readLine()) != null) {

				boolean result = pattern.matcher(line).matches();
				System.out.println("Result: "+((result) ? "matches regex" : "does not match") +".\n\t\t Text: "+line);
			}
			
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}
		
	}
}
