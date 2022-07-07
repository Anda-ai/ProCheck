package com.kapelle.procheck.Storage;

import javax.servlet.ServletContext;

public class Paths {
    Long user_id;
    String main_dir;
    public String profile_dir;
    public String post_dir;
    public String project_dir;
    public Paths(Long user_id, ServletContext context){
        this.user_id = user_id;
        this.main_dir = context.getRealPath("")+"/WEB-INF";
        this.profile_dir = main_dir+"/files/images/"+user_id+"/profiles";
        this.post_dir = main_dir+"/files/images/"+user_id+"/posts";
        this.project_dir = main_dir+"/files/images/"+user_id+"/projects";
        System.out.println("profile_dir: "+profile_dir);
        System.out.println("post_dir: "+post_dir);
        System.out.println("project_dir: "+project_dir);
    }
}
