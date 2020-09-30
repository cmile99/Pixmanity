package com.threeklines.pixmanity;

import java.util.ArrayList;

public class PortfolioProject {
    private String projectName;
    private int projectImage;
    private ArrayList<Integer> projectImages;

    public PortfolioProject(String projectName, int projectImage, ArrayList<Integer> projectImages) {
        this.projectName = projectName;
        this.projectImage = projectImage;
        this.projectImages = projectImages;
    }

    public String getProjectName() {
        return projectName;
    }

    public int getProjectImage() {
        return projectImage;
    }

    public ArrayList<Integer> getProjectImages() {
        return projectImages;
    }
}
