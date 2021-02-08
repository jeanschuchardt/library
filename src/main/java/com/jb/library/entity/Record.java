package com.jb.library.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Record {
    int bookid;
    int borrowerid;

}
