package redline.ibformation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import redline.ibformation.entity.Evaluation;
import redline.ibformation.service.EvaluationService;


import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/Evaluation")
public class EvaluationController {

    @Autowired
    private EvaluationService evaluationService;

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Evaluation> findAll(){
        return this.evaluationService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Evaluation findById(@PathVariable Long id) {
        return this.evaluationService.findById(id);
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Evaluation create(@RequestBody Evaluation evaluation) {
        return this.evaluationService.create(evaluation);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Evaluation update(@RequestBody Evaluation evaluation, @PathVariable Long id) {
        if (!id.equals(evaluation.getId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Mauvaise évaluation à mettre à jour");
        }
        return this.evaluationService.update(evaluation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        this.evaluationService.delete(id);
    }
}
