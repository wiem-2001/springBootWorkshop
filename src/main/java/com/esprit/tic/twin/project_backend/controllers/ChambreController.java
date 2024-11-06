package com.esprit.tic.twin.project_backend.controllers;

import com.esprit.tic.twin.project_backend.services.IChambreService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChambreController {
    IChambreService chambreService;
}
