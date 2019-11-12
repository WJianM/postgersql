package com.wjm.postgers.web;

import com.wjm.postgers.domain.TbMoude;
import com.wjm.postgers.pojo.PageResult;
import com.wjm.postgers.service.MoudeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("moude")
public class MoudeController {
    @Autowired
    private MoudeService moudeService;

    @GetMapping
    public ResponseEntity<List<TbMoude>> findAll() {

        List<TbMoude> all = moudeService.findAll();
        if (StringUtils.isEmpty(all)) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.ok(all);
    }

    @GetMapping("page")
    public ResponseEntity<PageResult<TbMoude>> findByPage(
            @RequestParam(name = "page", defaultValue = "1") int pageNo,
            @RequestParam(name = "size", defaultValue = "10") int pageSize,
            String moudename) {
        PageResult<TbMoude> MoudePageResult = moudeService.queryBrandPage(pageNo, pageSize, null, false, moudename);
        if (StringUtils.isEmpty(MoudePageResult)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(MoudePageResult);

    }

    @GetMapping("{id}")
    public ResponseEntity<TbMoude> findById(@PathVariable(name = "id") int id) {

        return ResponseEntity.ok(moudeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<TbMoude> save(TbMoude moude) {
        this.moudeService.save(moude);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<TbMoude> update(TbMoude moude) {
        this.moudeService.update(moude);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @DeleteMapping("{id}")
    public ResponseEntity<TbMoude> deleteById(@PathVariable("id") int id) {
        this.moudeService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }



}
