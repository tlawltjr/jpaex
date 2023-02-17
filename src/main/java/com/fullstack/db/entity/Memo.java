package com.fullstack.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

//이 클래스는 엔티티 객체로 활용될 예정입니다
//엔티티로 활용되기 위해서 어노테이션 이용해서 엔티티 선언을 해줘야 합니다
//대표적으로는 entity, tablle(value="생성될 테이블명")정도입니다
//이 선언문은 클래스에 선언을 해야 엔티티로 적용되어집니다

@Entity
@Table(name="tbl_memo")//tbl_memo라는 테이블에 맵핑을 합니다
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Memo {
	//엔티티클래스는 맵핑된 테이블의 컬럼에 사용될 필드를 선언합니다
	//보통은 PK를 갖도록 정의되어져서 PK 컬럼을 ID로 선언하고
	//PK전략(stratagy)즉 PK값을 누가 생성할 지를 속성으로 명명합니다
	
	//보통 스프링에서는 ptype의 데이터를 사용하지 않습니다
	//즉 모든 데이터는 객체형태여야합니다
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long mno;
	
	@Column(length = 200, nullable = false)
	private String memoTxt;
	
	
}
