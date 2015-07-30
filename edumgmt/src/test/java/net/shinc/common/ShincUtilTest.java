package net.shinc.common;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class ShincUtilTest {
	
	@Mock
	private BindingResult bindResult; 
	
	private List<FieldError> lf;
	@Before
	public void setUp() {
        MockitoAnnotations.initMocks( this );
        FieldError fe = new FieldError("a", "name", "不能为空");
        FieldError fe2 = new FieldError("b", "phone", "格式不正确");
        lf = new ArrayList();
        lf.add(fe);
        lf.add(fe2);
        
	}
	@Test
	public void getErrorFields() {
		when(bindResult.getFieldErrors()).thenReturn(lf);
		
		System.out.println(ShincUtil.getErrorFields(bindResult));
	}

}
