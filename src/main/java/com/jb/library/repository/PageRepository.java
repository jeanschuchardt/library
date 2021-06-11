package com.jb.library.repository;

import com.jb.library.entity.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("pageRepository")
public interface PageRepository  extends JpaRepository<Page, Integer> {


}
