package com.designProject.Pastebin.JpaRepository;

import com.designProject.Pastebin.models.AccountInfo;
import com.designProject.Pastebin.models.PastedNotes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountInfoRepository extends JpaRepository<AccountInfo,String> {
    AccountInfo findByAccountId(String accountId);

}
