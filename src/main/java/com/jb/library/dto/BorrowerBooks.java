package com.jb.library.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class BorrowerBooks {
    String fullName;
    HashMap<Integer,String> book;

}
