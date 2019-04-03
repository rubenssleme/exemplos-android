package br.com.bg.viagens.api;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hoteis/*")
public class HoteisServlets extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.getOutputStream().print("{\"id\":1,\"nome\":\"hotelBG\",\"endereco\":\"Avenida Paulista, 1234\"}");	
	resp.setStatus(HttpServletResponse.SC_OK);	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		InputStream is = req.getInputStream();
		byte[] dados = new byte[req.getContentLength()];
		
		int index = 0;
		
		while(index < dados.length -1){
			index = index + is.read(dados, index, is.available());
		}
		System.out.println(new String(dados));
		resp.setStatus(HttpServletResponse.SC_OK);
	}
}
