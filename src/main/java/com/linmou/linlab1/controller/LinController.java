package com.linmou.linlab1.controller;



import com.linmou.linlab1.enumuation.ServiceExceptionEnum;
import com.linmou.linlab1.handler.ServiceException;
import com.linmou.linlab1.vo.CommonResult;
import com.linmou.linlab1.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.UUID;

/**
 * @author linMou
 * @Description:
 * @Date: 2020/5/13 15:11
 * @Version: 1.0
 */
@RestController
@RequestMapping("/lin")
@Slf4j
public class LinController {

    @RequestMapping("/{userId}")
    public UserVo get(@PathVariable String userId) {

        UserVo vo = new UserVo();
        vo.setUserId(userId);
        vo.setUserName(UUID.randomUUID().toString());

        return vo;

    }
    @RequestMapping("get/{userId}")
    public CommonResult<UserVo> getUser(@PathVariable String userId) {
        UserVo vo = new UserVo();
        vo.setUserId(userId);
        vo.setUserName(UUID.randomUUID().toString());

        return CommonResult.success(vo);
    }

    // UserController.java

    /**
     * 测试抛出 NullPointerException 异常
     */
    @GetMapping("/e1")
    public UserVo exception01() {
        throw new NullPointerException("没有粗面鱼丸");
    }

    /**
     * 测试抛出 ServiceException 异常
     */
    @GetMapping("/e2")
    public UserVo exception02() {
        throw new ServiceException(ServiceExceptionEnum.USER_NOT_FOUND);
    }

    @GetMapping("/do_something")
    public void doSomething() {
        log.info("[doSomething]");
    }
}
