package br.com.caelum.livraria.bean;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/consultaCadastramento")
public class ConsultaTeste {
//		private final Logger logger = LoggerUtils.initLoggerAllPackage(ConsultaCadastramentoController.class);
//		private ErrorResponse errorResponse = new ErrorResponse(ErrorEnum.ERRO_GENERICO);
	private String nomeMetodo;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/c/consultaCadastramento")
	public Response consultaBiometriaCadastramento() {
		nomeMetodo = "consultaCadastramento";
		try {
			return Response.ok("erro 200").build();
		} catch (Exception e) {
//				LoggerUtils.loggerError(logger, getClass().getSimpleName(), nomeMetodo, e.getMessage());
			return Response.ok("erro 500").build();
		}
	}

}
