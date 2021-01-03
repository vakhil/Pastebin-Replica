package com.designProject.Pastebin.JpaRepository;

import com.designProject.Pastebin.models.PastedNotes;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;

import javax.persistence.QueryHint;
import java.util.List;


public interface PastebinRepository extends JpaRepository<PastedNotes,String> {
    PastedNotes findByUrlAddress(String urlAddress);
   List<PastedNotes> findByAccountId(String accountId);
    @Cacheable("books")
    Page<PastedNotes> findByAccountIdOrderByTimestampDesc(String user, Pageable pageable);
}
