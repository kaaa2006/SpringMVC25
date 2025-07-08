package org.zeroock.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class) //메서스단위 테스트 코드
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//테스트시 사용할 코드 
@Log4j2 //log4 취약해서 j2로 교체

public class HotelTests {
	@Setter (onMethod_ = @Autowired)
	private SampleHotel hotel;
	
	@Test
	public void testExist() {
		assertNotNull(hotel);
		log.info(hotel);
		log.info("--------------");
		log.info(hotel.getChef());

	}
}
