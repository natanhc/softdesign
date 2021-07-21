package com.example.voto.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.softdesign.voto.enumeration.OpcaoEnum;
import com.softdesign.voto.model.Voto;
import com.softdesign.voto.service.impl.ResultadoServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ResultadoServiceTeste {

	@InjectMocks
	private ResultadoServiceImpl service;

	@Test
	public void retornarVerdadeiraQuandoVotoSim() throws Exception {
		Voto voto = new Voto();
		voto.setResposta(OpcaoEnum.SIM.getValor());
		assertTrue(service.filtrarPorOpcao(voto, OpcaoEnum.SIM));
	}
	
	@Test
	public void retornarVerdadeiraQuandoVotoNao() throws Exception {
		Voto voto = new Voto();
		voto.setResposta(OpcaoEnum.NAO.getValor());
		assertTrue(service.filtrarPorOpcao(voto, OpcaoEnum.NAO));
	}
	
	@Test
	public void retornarFalsoQuandoOpcaoNull() throws Exception {
		Voto voto = new Voto();
		assertFalse(service.filtrarPorOpcao(voto, OpcaoEnum.SIM));
	}
}
