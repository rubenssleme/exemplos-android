package br.com.bg.viagens.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.bg.viagens.model.Hotel;


@WebServlet("/hoteis")
public class HotelServelet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	ObjectMapper objectMapper  = new ObjectMapper();
	
	Hotel hotelBG = new Hotel();
	hotelBG.setId(1);
	hotelBG.setNome("Hotel do BG");
	hotelBG.setEndereco("Rua Guaipa, 1300");
	
	objectMapper.writeValue(resp.getOutputStream(),Hotel.class);
	
	}
}
