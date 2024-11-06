package com.esprit.tic.twin.project_backend.controllers;

import com.esprit.tic.twin.project_backend.services.ITacheService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TacheController {
    ITacheService tacheService;
}
