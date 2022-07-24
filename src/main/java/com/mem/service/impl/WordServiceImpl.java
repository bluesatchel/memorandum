package com.mem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mem.model.Word;
import com.mem.mapper.WordMapper;
import com.mem.service.WordService;
import org.springframework.stereotype.Service;

@Service
public class WordServiceImpl extends ServiceImpl<WordMapper, Word> implements WordService {

}
