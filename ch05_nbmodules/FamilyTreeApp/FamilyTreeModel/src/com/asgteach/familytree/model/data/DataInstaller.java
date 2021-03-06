/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asgteach.familytree.model.data;

import com.asgteach.familytree.model.FamilyTreeManager;
import com.asgteach.familytree.model.Person;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openide.LifecycleManager;
import org.openide.modules.OnStart;
import org.openide.util.Lookup;

/**
 *
 * @author gail
 */
@OnStart
public final class DataInstaller implements Runnable {
    private static final Logger logger = Logger.getLogger(DataInstaller.class.getName());

    @Override
    public void run() {
        FamilyTreeManager ftm = Lookup.getDefault().lookup(FamilyTreeManager.class);
        if (ftm == null) {
            logger.log(Level.SEVERE, "Cannot get FamilyTreeManager object");
            LifecycleManager.getDefault().exit();
        }
        populateMap(ftm);
    }
    
    private void populateMap(FamilyTreeManager ftm) {
        // put some dummy data into the FamilyTreeManager map
        ftm.addPerson(new Person("Homer", "Simpson", Person.Gender.MALE));
        ftm.addPerson(new Person("Marge", "Simpson", Person.Gender.FEMALE));
        ftm.addPerson(new Person("Bart", "Simpson", Person.Gender.MALE));
        ftm.addPerson(new Person("Lisa", "Simpson", Person.Gender.FEMALE));
        ftm.addPerson(new Person("Maggie", "Simpson", Person.Gender.FEMALE));
        logger.log(Level.INFO, "Map populated: {0}", ftm.getAllPeople());
    }
    
}
