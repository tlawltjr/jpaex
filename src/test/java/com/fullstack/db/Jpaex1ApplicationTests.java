package com.fullstack.db;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.fullstack.db.entity.Memo;
import com.fullstack.db.repository.MemoRepository1;

import jakarta.transaction.Transactional;


@SpringBootTest
class Jpaex1ApplicationTests {

	/*
	 * 실행시에 객체를 자동 주입 시켜주는 대표적 API AutoWired입니다
	 * 이 어노테이션을 사용하면 프레임워크가 자동으로 해당 인스턴스를 생성해서
	 * 주입(Injection) 해줍니다. 이런건 IOC합니다 (제어역전컨트롤러)
	 */
	
	@Autowired
	MemoRepository1 memorepository;
	
//	@Test
//	void contextLoads() {
//		IntStream.rangeClosed(1, 100).forEach(i->{
//			Memo memo = Memo.builder().memoTxt("이건 JPA 엔티티가 넣은 데이터"+i).build();
//			memorepository.save(memo);
//			
//		});
//		
//	}	
	
//	@Test
//	void testSelect() {
//		Long mno =1000L;
//		
//		Optional<Memo> result = memorepository.findById(mno);
//		System.out.println("==============");
//		
//		if(result.isPresent()) {
//			Memo memo = result.get();
//			System.out.println(memo);
//		}
//	}
	
	/*
	 * getOne(조회PK값) --> 위의findById와 유사한데, 틀린점은 
	 * Transactional 어노테이션이 반드시 들어가야 합니다
	 * 나머진 위와같습니다
	 */
//	@Transactional
//	@Test
//	void testSelect() {
//		Long mno = 55L;
//		
//		Memo memo = memorepository.getOne(mno);
//		
//		System.out.println("==============>"+memo);
//	}
	
	/*
	 * DB삭제 : repository 의 deleteSomething() 을 호출해서 지우면 됩니다
	 * 만약 특정 Row를 삭제하려고 할떄 해당 로우넘이 없으면 예외를 발생합니다
	 * 그 점은 확인하시면 됩니다. ERDAExcption(축약한 예외 이름)
	 */
//	@Test
//	public void delete() {
//		Long mno = 200L;
//		//memorepository.deleteById(mno);
//		memorepository.deleteAll();
//	}
	
//	@Test
//	public void updateTest() {
//		//수정할 Entity의 내용을 변경해 볼게요
//		Memo memo = Memo.builder().mno(301L).memoTxt("이건 수정된 내용입니다").build();
//		System.out.println(memorepository.save(memo));
//	}
	
	/*
	 * Pageable 인터페이스 : 페이징 관리를 하는 중심 인터페이스
	 * 
	 * 위 인터페이스 PageRequest 객체의 of 메서드를 이용해서 얻을 수 있습니다
	 * 이때 얻어낼 목록이나, 정렬 등을 지정해서 사용할 수 있습니다
	 * 
	 */
	//페이징을 위한 테스트 메서드 정의
//	@Test
//	public void testPaging1() {
//		Pageable pageable = PageRequest.of(0, 10);
//		Page<Memo> result = memorepository.findAll(pageable);
//		
//		System.out.println(result);
		
//		System.out.println("++++++++++++++++++++++++++++++");
//		System.out.println("getTotalPages : "+result.getTotalPages());
//		System.out.println("getNumber : "+result.getNumber());
//		System.out.println("getelements : "+result.getNumberOfElements());
//		System.out.println("size : "+result.getSize());
//		System.out.println(result.getTotalElements());
//		System.out.println(result.hasNext());
//		System.out.println(result.hasPrevious());
//		System.out.println(result.isEmpty());
		
		//Sort객체를 얻어낼떄 정렬될 키의 값을 주고, 정렬메서드를 통해 
		//정렬된 Sort객체를 얻어낼 수 있습니다
//		Sort s1 = Sort.by("mno").ascending();
//		Sort s2 = Sort.by("memoTxt").descending();
//		Sort s3 = s1.and(s2);
//		
//		//방법 1.memorepository.findAll()
//		pageable = PageRequest.of(0, 10, s3);
//		result = memorepository.findAll(pageable);
//		
//		//foreach 구문을 이용해서 위 result의 값을 출력해보세요
//		
//		result.get().forEach(memo ->{
//			System.out.println("======="+memo);
//		});
//		
//	}
	
//	@Test
//	public void testQueryMethod() {
//		
//		List<Memo> list = memorepository.findByMnoBetweenOrderByMnoDesc(201L, 300L);
//		System.out.println("=========="+list);
//	}
	
	@Test
	public void testQueryMethod() {
		
		Pageable pageable = PageRequest.of(0, 10, Sort.by("mno").descending());
		Page<Memo> page = memorepository.findByMnoBetween(201L, 301L, pageable);
		System.out.println("=========="+page);
	}
	
	
	
	
	
	
	
}
