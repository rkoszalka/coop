package org.koszalka.coop.api.v1;


import org.koszalka.coop.dto.ResultDTO;
import org.koszalka.coop.services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/result")
public class ResultController {

    private final ResultService resultService;

    @Autowired
    public ResultController(ResultService resultService) {
        this.resultService = resultService;

    }

    @GetMapping("/{id}")
    public ResponseEntity<ResultDTO> getResult(@PathVariable Long id) {
        ResultDTO resultDTO = resultService.getAgendaResult(id);
        return new ResponseEntity<>(resultDTO, HttpStatus.OK);
    }
}
