package io.caicloud.test.controller;

import java.util.concurrent.atomic.AtomicLong;

import io.caicloud.test.model.CaicloudDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * Created by junpeng.chu on 2018/1/4.
 */
@RestController
@RequestMapping("caicloud")
public class CaicloudController {
    @GetMapping("info")
    public CaicloudDTO getCaicloudInfo(){
        return new CaicloudDTO("才云科技", "400-1014-588", "杭州市滨江区六和路368号海创基地北楼B3082");
    }
}
