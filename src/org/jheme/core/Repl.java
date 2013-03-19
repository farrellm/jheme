package org.jheme.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Repl {
	public static void main(String[] args) {
		System.out.println("jheme");
		while (true) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        System.out.print("> ");
	        try {
				String s = br.readLine();
                if ("QUIT".equals(s))
                    break;
				List<String> tokens = Parser.tokens(s);
				System.out.println(tokens);
				List<Object> lst = Parser.parse(tokens);
				System.out.println(lst);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
