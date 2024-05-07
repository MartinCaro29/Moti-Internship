package com.ikub.motidatabase.service;
import static org.mockito.BDDMockito.verify;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;

import com.ikub.motidatabase.entity.Moti;
import com.ikub.motidatabase.repository.MotiRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)

public class MotiServiceTest {
    @Mock
    private MotiRepository motiRepo;
    @InjectMocks
    private MotiService motiService;

    @Test
    public void testSaveDetails() {

        Moti motiToSave = new Moti(1, "Tirane", "2024-04-24", 25, 67);
        Mockito.when(motiRepo.save(motiToSave)).thenReturn(motiToSave);
        Moti savedMoti = motiService.saveDetails(motiToSave);
        assertEquals(motiToSave, savedMoti);
    }

    @Test
    void testGetAllDetails() {
        Moti m1 = new Moti(1, "Korce", "24-04-30", 22, 55);
        Moti m2 = new Moti(2, "Tirane", "24-05-01", 20, 60);

        given(motiRepo.findAll()).willReturn(List.of(m1, m2));
        var motiList = motiService.getAllDetails();

        assertThat(motiList).isNotNull();
        assertThat(motiList.size()).isEqualTo(2);
    }

    @Test
    public void testUpdateDetail_WhenMotiExists() {

        Moti motiToUpdate = new Moti(1, "Tirane", "2024-04-24", 25, 67);


        Mockito.when(motiRepo.findById(motiToUpdate.getMatje_id()))
                .thenReturn(Optional.of(motiToUpdate));
        Mockito.when(motiRepo.save(motiToUpdate)).thenReturn(motiToUpdate);
        Moti updatedMoti = motiService.updateDetail(motiToUpdate);
        assertEquals("Tirane", updatedMoti.getQyteti());
    }

    @Test
    public void testUpdateDetail_WhenMotiNotExists() {

        Moti motiToUpdate = new Moti(100, "Tirane", "2024-04-24", 25, 67);
        Mockito.when(motiRepo.findById(motiToUpdate.getMatje_id()))
                .thenReturn(Optional.empty());
        Moti updatedMoti = motiService.updateDetail(motiToUpdate);
        assertNull(updatedMoti);
    }

    @Test
    public void testDeleteMoti_WhenExists() {

        Mockito.when(motiRepo.existsById(1)).thenReturn(true);
        String result = motiService.deleteMoti(1);
        assertEquals("deleted 1", result);
    }

    @Test
    public void testDeleteMoti_WhenNotExists() {

        Mockito.when(motiRepo.existsById(100)).thenReturn(false);
        String result = motiService.deleteMoti(100);
        assertEquals("id is invalid", result);
    }
}


