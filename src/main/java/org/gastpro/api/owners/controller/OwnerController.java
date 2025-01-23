package org.gastpro.api.owners.controller;

import org.gastpro.api.owners.domain.Owner;
import org.gastpro.api.owners.domain.OwnerService;
import org.gastpro.api.owners.domain.dto.OwnerDetailUpdate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/owners")
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping("/update")
    public Owner updateOwner(@RequestBody OwnerDetailUpdate ownerDetailUpdate) {
        return ownerService.updateOwner(ownerDetailUpdate);
    }
}
