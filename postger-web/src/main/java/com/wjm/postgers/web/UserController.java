package com.wjm.postgers.web;

import com.wjm.postgers.domain.TbUser;
import com.wjm.postgers.pojo.PageResult;
import com.wjm.postgers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<TbUser>> findAll() {

        List<TbUser> all = userService.findAll();
        if (StringUtils.isEmpty(all)) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.ok(all);
    }

    @GetMapping("page")
    public ResponseEntity<PageResult<TbUser>> findByPage(
            @RequestParam(name = "page", defaultValue = "1") int pageNo,
            @RequestParam(name = "size", defaultValue = "10") int pageSize,
            String username) {
        PageResult<TbUser> tbUserPageResult = userService.queryBrandPage(pageNo, pageSize, null, false, username);
        if (StringUtils.isEmpty(tbUserPageResult)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(tbUserPageResult);

    }

    @GetMapping("{id}")
    public ResponseEntity<TbUser> findById(@PathVariable(name = "id") int id) {

        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping
    public ResponseEntity<TbUser> save(TbUser user) {
        this.userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<TbUser> update(TbUser user) {
        this.userService.update(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @DeleteMapping("{id}")
    public ResponseEntity<TbUser> deleteById(@PathVariable("id") int id) {
        this.userService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }



}
