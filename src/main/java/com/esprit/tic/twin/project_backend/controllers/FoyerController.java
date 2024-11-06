package com.esprit.tic.twin.project_backend.controllers;

import com.esprit.tic.twin.project_backend.services.IFoyerService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoyerController {
    IFoyerService foyerService;
}