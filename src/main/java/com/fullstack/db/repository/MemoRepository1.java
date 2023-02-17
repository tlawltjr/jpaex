package com.fullstack.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fullstack.db.entity.Memo;

public interface MemoRepository1 extends JpaRepository<Memo, Long> {

}
