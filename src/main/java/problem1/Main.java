package problem1;

import org.springframework.beans.BeanUtils;

import java.beans.PropertyDescriptor;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Main main = new Main();
        System.out.println(main.getRatioBetweenSimpleAndComplexPropertiesInAPackage("problem1"));
    }

    public double getRatioBetweenSimpleAndComplexProperties(Class clasa) {
        PropertyDescriptor[] propertyDescriptors = BeanUtils.getPropertyDescriptors(clasa);
        double simpleProperties = 0;
        for (int i = 1; i < propertyDescriptors.length; i++) {
            if (BeanUtils.isSimpleProperty(propertyDescriptors[i].getPropertyType())) {
                simpleProperties++;
            }
        }

        return simpleProperties / (propertyDescriptors.length - 1) * 100;
    }


    //    --------------------------------------BONUS POINT--------------------------------------

    public double getRatioBetweenSimpleAndComplexPropertiesInAPackage(String package1) {
        Class[] classes = getClassesInPackage(package1);
        double packageRatio = 0;
        int noOfProperties = 0;
        for (Class c : classes) {
            if (!Double.isNaN(getRatioBetweenSimpleAndComplexProperties(c)))
            {
                packageRatio += getRatioBetweenSimpleAndComplexProperties(c);
                noOfProperties++;
            }

        }
        return packageRatio / noOfProperties;
    }

    private static Class[] getClassesInPackage(String pckgname) {
        File directory = getPackageDirectory(pckgname);
        if (!directory.exists()) {
            throw new IllegalArgumentException("Could not get directory resource for package " + pckgname + ".");
        }

        return getClassesInPackage(pckgname, directory);
    }

    private static Class[] getClassesInPackage(String pckgname, File directory) {
        List<Class> classes = new ArrayList<Class>();
        for (String filename : directory.list()) {
            if (filename.endsWith(".class")) {
                String classname = buildClassname(pckgname, filename);
                try {
                    classes.add(Class.forName(classname));
                } catch (ClassNotFoundException e) {
                    System.err.println("Error creating class " + classname);
                }
            }
        }
        return classes.toArray(new Class[classes.size()]);
    }

    private static String buildClassname(String pckgname, String filename) {
        return pckgname + '.' + filename.replace(".class", "");
    }

    private static File getPackageDirectory(String pckgname) {
        ClassLoader cld = Thread.currentThread().getContextClassLoader();
        if (cld == null) {
            throw new IllegalStateException("Can't get class loader.");
        }

        URL resource = cld.getResource(pckgname.replace('.', '/'));
        if (resource == null) {
            throw new RuntimeException("Package " + pckgname + " not found on classpath.");
        }

        return new File(resource.getFile());
    }

}