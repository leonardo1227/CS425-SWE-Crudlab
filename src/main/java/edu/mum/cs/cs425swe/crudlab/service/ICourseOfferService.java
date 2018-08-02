package edu.mum.cs.cs425swe.crudlab.service;

import edu.mum.cs.cs425swe.crudlab.model.CourseOffer;

import java.util.List;

public interface ICourseOfferService {
    public abstract List<CourseOffer> findAll();
    public abstract CourseOffer findById(Long id);
    public abstract CourseOffer save(CourseOffer courseOffer);
    public abstract void deleteById(Long id);
}
