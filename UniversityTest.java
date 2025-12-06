import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This UniversityTest class provides different methods of checking the behaviour
 * of the University class and the objects that it uses. It maintains a
 * reference to a University object called 'stirling' and populates it via
 * the loadData method.
 *
 * If you run this class via a call to main, main will create
 * a University object and call the go method which produces some useful output that
 * you can analyse.
 *
 * Implement the unit test methods for
 *
 * (i) tree walk method
 * (ii) tree find method
 * (iii) list search
 * (iv) list sorting
 * (v) graph loop
 * (vi) check enrolment size
 *
 */
public class UniversityTest
{
    University stirling = new University();

    public static void main(String[] args)
    {
        UniversityTest test = new UniversityTest();
        test.go();
    }

    @BeforeEach
    public void loadData()
    {
        stirling.clear();

        Professor[] Data = new Professor[]{ new Professor("Alek Sib", 159, "aleksib@stir.ac.uk", "CSM", 1.0),
                new Professor("Jill Lai", 369, "jl@stir.ac.uk", "CSM", 0.5),
                new Professor("Kevin Jack", 789, "kj@stir.ac.uk", "CSM", 1.0),
                new Professor("Guy F", 654, "gf@stir.ac.uk", "BES/CSM", 0.75),
                new Professor("Loius V", 643, "lv@stir.ac.uk", "CSM", 0.25),
                new Professor("Lett A", 580, "la@stir.ac.uk", "CSM", 0.5),
                new Professor("Stephanie A", 999, "sa@stir.ac.uk", "BES/CSM", 1.0),};

        Student[] data = new Student[]{ new Student("John J", 147, "jj@stir.ac.uk"),
                new Student("Kate K", 565, "kk@stir.ac.uk"),
                new Student("Loius L", 6542, "ll@stir.ac.uk"),
                new Student("Zhang Z", 805, "zz@stir.ac.uk"),
                new Student("Xing L", 100, "xl@stir.ac.uk"),
                new Student("Alma A", 753, "aa@stir.ac.uk"),
                new Student("Borba B", 888, "bb@stir.ac.uk"),
                new Student("Zeus L", 001, "zl@stir.ac.uk"),
                new Student("Laura Q", 075, "lq@stir.ac.uk"),
                new Student("Pierre A", 130, "pa@stir.ac.uk"),
                new Student("Jess Z", 010, "jz@stir.ac.uk"),
                new Student("Hugh J", 101, "hj@stir.ac.uk"),
                new Student("Paul P", 654, "pp@stir.ac.uk")}; // include here some MSc Students

        Module algorithm1 = new Module(147, "Algorithms 1");
        Module algorithm2 = new Module(199, "Algorithms 2");
        algorithm2.addPrerequisites(algorithm1);
        Module algorithm3 = new Module(201, "Algorithms 3");
        algorithm3.addPrerequisites(algorithm1);
        Module datastructure = new Module(250, "Data Structure");
        datastructure.addPrerequisites(algorithm1);
        datastructure.addPrerequisites(algorithm2);
        datastructure.addPrerequisites(algorithm3);
        Module dataScience = new Module(101, "Introduction to Data Science", new ArrayList<Module>(Arrays.asList(algorithm1)));
        Module machinelearning = new Module(301, "Machine Learning");
        Module deepLearning = new Module(401, "Deep Learning");
        datastructure.addPrerequisites(deepLearning); //
        datastructure.addPrerequisites(algorithm1);
        datastructure.addPrerequisites(datastructure);
        machinelearning.addPrerequisites(algorithm2);
        machinelearning.addPrerequisites(algorithm3);
        machinelearning.addPrerequisites(dataScience);
        deepLearning.addPrerequisites(algorithm1);
        deepLearning.addPrerequisites(machinelearning);
        Module nlp = new Module(450, "Natural Language Processing");
        nlp.addPrerequisites(machinelearning);
        nlp.addPrerequisites(deepLearning);
        nlp.addPrerequisites(dataScience);
        Module Cn = new Module(475, "Computer Networks", new ArrayList<Module>(Arrays.asList(algorithm1)));
        Module graphics = new Module(501, "Computer Graphics", new ArrayList<Module>(Arrays.asList(algorithm2)));

        Cohort c1 = new Cohort(deepLearning, new BinaryTree(new Student[]{data[0],data[1], data[2], data[5]}), Data[0]);
        stirling.addClass(c1);

        Cohort c2 = new Cohort(machinelearning, new BinaryTree(new Student[]{data[3], data[4], data[6]}), Data[1]);
        stirling.addClass(c2);

        Cohort c3 = new Cohort(algorithm3, new BinaryTree(new Student[]{data[6], data[10], data[11], data[10]}), Data[2]);
        stirling.addClass(c3);

        Cohort c4 = new Cohort(datastructure, new BinaryTree(new Student[]{data[5], data[4], data[0], data[11], data[10]}), Data[3]);
        stirling.addClass(c4);

        Cohort c5 = new Cohort(datastructure, new BinaryTree(new Student[]{data[0], data[1], data[6], data[7], data[8]}), Data[4]);
        stirling.addClass(c5);

        Cohort c6 = new Cohort(algorithm2, new BinaryTree(new Student[]{data[2], data[5], data[6], data[9]}), Data[5]);
        stirling.addClass(c6);

        Cohort c7 = new Cohort(algorithm1, new BinaryTree(new Student[]{data[7], data[8], data[9], data[10], data[11]}), Data[6]);
        stirling.addClass(c7);

    }

    /**
     * Print the contents of the ArrayList 'list' to standard output.
     * @param list The list to print
     */
    public void printArrayList(ArrayList<Cohort> list)
    {
        for (Cohort v:list)
        {
            System.out.println(v.toString());
        }
    }

    /**
     * 'go' produces a useful set of output that allows you to see the
     * initial state of the modules arraylist, the results of doing the
     * tree walk, an attempt at finding an object in the tree and
     * the results of doing a sort and a search. Initially,
     * only the state of the modules list will be correct. As you add
     * further functionality, you should see the correct output being
     * printed via this method. You do not need to modify it but you may
     * want to add your own checks to confirm your code is working as intended.
     */
    public void go()
    {
        loadData();
        System.out.println("--Module List--");
        stirling.describeModuleList();
        System.out.println();

        System.out.println("\n--Tree Walk--\n" + stirling.walkTree(5, "inOrder"));
        System.out.println("\n--Tree Walk--\n" + stirling.walkTree(5, "custom"));

        System.out.println("\n--Find--");
        Student mf = stirling.find(0, "John J"); // should be found
        if (mf != null)
            System.out.println("Found: " + mf);
        else
            System.out.println("Could not find John J");

        Student aw = stirling.find(1, "Jack J"); // should not be found
        if (aw != null)
            System.out.println("Found: " + aw);
        else
            System.out.println("Could not find Jack J");

        System.out.println("\n--Searching module name--");
        // Reload the data, otherwise it will still be sorted...
        loadData();
        Module s = stirling.searchForModule("Natural Language Processing");
        if (s != null)
            System.out.println("Found module: " + s);
        else
            System.out.println("Could not find module");
        Module sw = stirling.searchForModule("Introduction to Data Science");
        if (sw != null)
            System.out.println("Found module: " + sw);
        else
            System.out.println("Could not find module");

        System.out.println("\n--Sort ascending name--");
        ArrayList<Cohort> sorted;
        // Reload the data, otherwise it will still be sorted...
        loadData();
        sorted = stirling.sortMethod(true, "name");
        printArrayList(sorted);

        System.out.println("\n--Sort descending code--");
        // Reload the data, otherwise it will still be sorted...
        loadData();
        sorted = stirling.sortMethod(false, "code");
        printArrayList(sorted);

    }

    /**
     * A test for the tree walk
     */
    @Test
    public void walkTest()
    {
        //TODO done
        int coIndex = 4;
        //Assuming walkTree returns a single string of comma seperated values
        String walkAnswer = stirling.walkTree(coIndex, "inOrder");
        assertNotNull(walkAnswer, "The inOrder walk should not return null.");
        //to check that the walk contains the names of all 5 unique students
        String[] students = walkAnswer.split(",");
        assertEquals(5, students.length, "The inOrder walk for Cohort 4 should return 5 student names");
    }

    /**
     * A test for the graph loop
     */
    @Test
    public void loopSearchTest()
    {
        // TODO done
        University uni = new University();
        Professor Prof = new Professor("Dr. Test", 999, "test@stir.ac.uk", "CS", 1.0);
        //creating 3 modules (1,2,3)
        Module module1 = new Module(101, "CompSci A");
        Module module2 = new Module(102, "CompSci B");
        Module module3 = new Module(103, "CompSci C");
        //establishing the cycle, 1 to 2 to 3 to 1
        //edge 3 to 1
        module3.addPrerequisites(module1);
        //edge 2 to 3
        module2.addPrerequisites(module3);
        //edge 1 to 2
        module1.addPrerequisites(module2);
        //creating cohorts
        Cohort cohortX = new Cohort(module1, Prof);
        Cohort cohortY = new Cohort(module2, Prof);
        Cohort cohortZ = new Cohort(module3, Prof);
        //adding cohorts to university
        uni.addClass(cohortX);
        uni.addClass(cohortY);
        uni.addClass(cohortZ);
        //test the checkforcycles method
        boolean hasCycle = uni.checkForCycles();
        //assert that a cycle is found
        assertTrue(hasCycle, "The prerequisite graph must contain a cycle (A -> B -> C -> A) and checkForCycles() should return true.");
    }

    /**
     * A test for the tree find method
     */
    @Test
    public void findTest()
    {
        // TODO done
        int cIndex = 0;
        // to test for students that is in the tree
        String studentName = "John J";
        Student foundStudent = stirling.find(cIndex, studentName);
        assertNotNull(foundStudent, "Student " + studentName + " should be found in cohort 0.");
        assertEquals(studentName, foundStudent.getFullName(), "The found student's name should match the searched name.");
        // to test for students that is not in the tree
        String studentNameNotInTree = "Paul P";
        Student notFoundStudent = stirling.find(cIndex, studentNameNotInTree);
        assertEquals(null, notFoundStudent,"Student " + studentNameNotInTree + " should not be found in cohort 0.");
    }

    /**
     * A test for the tree find method, demonstrating a bug!
     */
    @Test
    public void findTestBugDemo()
    {
        stirling.getCohort().get(0).getBtree().printTree(); // Shows that Loius L is in the tree
        assertNotNull(stirling.getCohort().get(0).getBtree().find("Loius L")); // not found!
    }

    /**
     * A test for the search method
     */
    @Test
    public void searchTest()
    {
        // TODO done
        // to test for a module that is in the list
        String moduleNameInList = "Deep Learning";
        Module foundModule = stirling.searchForModule(moduleNameInList);
        assertNotNull(foundModule, "Module " + moduleNameInList + " should be found.");
        assertEquals(moduleNameInList, foundModule.getName(), "The found module's name should match the search name.");
        // to test for a module that is not in the list
        String moduleNameNotInList = "Quantum Computing";
        Module notFoundModule = stirling.searchForModule(moduleNameNotInList);
        assertEquals(null, notFoundModule, "Module " + moduleNameNotInList + " should not be found");
    }


    /**
     * A test for the sorting method
     */
    @Test
    public void sortingTest()
    {
        // TODO done
        ArrayList<Cohort> sorted;
        // to test sorting by asc name
        sorted = stirling.sortMethod(true, "name");
        assertEquals("Algorithms 1", sorted.get(0).getModule().getName(), "First module by name (ascending) should be Algorithms 1.");
        assertEquals("Machine Learning", sorted.get(6).getModule().getName(), "Last module by name (ascending) should be Machine Learning.");

        // to test sorting by desc code
        loadData();
        sorted = stirling.sortMethod(false, "code");
        assertEquals(401,sorted.get(0).getModule().getCode(), "First module by code (descending) should have code 401.");
        assertEquals(147,sorted.get(6).getModule().getCode(), "Last module by code (descending) should have code 147.");
    }

    // Test for Sorting Speed
    @Test
    public void sortingSpeedTest() {
        University uni = new University();
        int[] quantity = {100, 500, 1000, 5000, 10000};
        Random rand = new Random(1);
        ArrayList<Cohort> cohortObj = null;
        System.out.println("Quick sort timing information");
        System.out.println("-----------------------------");

        for (int size : quantity) {
            cohortObj = new ArrayList<>();

            for (int k = 0; k < size; k++) {
                Module m = new Module(k, "module" + (k + 1));
                Professor prof = new Professor("prof" + rand.nextInt(100), rand.nextInt(100), "prof" + rand.nextInt(100) + "@stir.ac.uk", "Div" + rand.nextInt(100), rand.nextDouble() *100);
                cohortObj.add(new Cohort(m, prof));
            }
            java.util.Collections.shuffle(cohortObj, rand);

            long start = System.nanoTime();
            ArrayList<Cohort> sorted = uni.sortMethod(cohortObj, 3, true, "name");
            long end = System.nanoTime();
            long time=end - start;
            System.out.println("Size:     "+size+","+" time "+time);
        }
    }

    /**
     * A test for the module enrolment
     */
    @Test
    public void checkModuleEnrolment()
    {
        // TODO done
        int coIndex = 6;
        int exSize = 5;
        //check the no. of nodes in the binary tree
        assertEquals(exSize, stirling.getCohort().get(coIndex).getBtree().size(), "The Algorithms 1 cohort (index 6) should have an enrollment size of 6.");
    }
}