package com.wjm.postgers.web;

import com.wjm.postgers.domain.TbRole;
import com.wjm.postgers.domain.TbUser;
import com.wjm.postgers.pojo.PageResult;
import com.wjm.postgers.service.RoleService;
import com.wjm.postgers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//@RestController
//@RequestMapping("user")
public class HelloController {

//    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @GetMapping
    public ResponseEntity<PageResult<TbUser>> findAll(){
        PageResult<TbUser> tbUserPageResult = userService.queryBrandPage(1, 1, null, false, null);
        if(tbUserPageResult == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(tbUserPageResult);
//        return ;

    }

    @PostMapping
    public ResponseEntity save(TbUser user){
        userService.save(user);
        return ResponseEntity.ok("保存成功");
    }
    @PostMapping("role")
    public void save(TbRole role){
        roleService.save(role);
    }
}
