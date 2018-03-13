package com.mircoservice.nameservice;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.mircoservice.nameservice.config.Properties;
import com.mircoservice.nameservice.web.NameController;

@RunWith(SpringRunner.class)
@WebMvcTest(NameController.class)
@AutoConfigureRestDocs
public class NameServiceApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private Properties properties;
	
	@Test
	public void testGetName() throws Exception {
		String expectedName = "Abdul Hafeez";
		Mockito.when(properties.getNames()).thenReturn(Arrays.asList(new String[]{expectedName}));
		mockMvc.perform(get("/name"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(expectedName))
		.andDo(document("name"));
	}

}
