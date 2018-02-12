/**
 * @author KEN
 *
 */
package com.grgbanking.initialize;

import java.lang.reflect.Field;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import com.grgbanking.entity.AbsBaseEntity;
import com.grgbanking.entity.SysUser;


public class InitEntityPropertyAspect {
    public void afterReturning(Object obj) {
        System.out.println("===========  service afterReturning ============");

//        Map<String,Transaction> tt=SystemContent.getAllHibernateTransactionLocal();
//        if(tt!=null){
//            Iterator<Entry<String, Transaction>> entries = tt.entrySet().iterator();
//            while (entries.hasNext()) {
//                Map.Entry<String, Transaction> entry = entries.next();
//                SystemContent.getHibernateSession(entry.getKey()).flush();
//                Transaction trans =entry.getValue();
//                if (trans != null && trans.isActive()) {
//                    trans.commit();
//                }
//            }
//        }
    }

    public void doAfter(JoinPoint jp) {
        System.out.println("=========== service 方法已执行 ============");
    }

    public void doAfterThrowing(JoinPoint jp, Exception ex) {
         System.out.println("===========  service 方法有异常 ============");
//        Map<String,Transaction> tt=SystemContent.getAllHibernateTransactionLocal();
//        if(tt!=null){
//            Iterator<Entry<String, Transaction>> entries = tt.entrySet().iterator();
//            while (entries.hasNext()) {
//                Map.Entry<String, Transaction> entry = entries.next();
//                Transaction trans =entry.getValue();
//                if (trans != null && trans.isActive()) {
//                    trans.rollback();
//                    // System.out.println("=========== 事物已回滚 ============");
//                }
//            }
//        }

    }

    public Object doAroundForAdd(ProceedingJoinPoint pjp) throws Throwable {
        Object args[] = pjp.getArgs();
        if (args.length >= 1) {
            if (args[0] instanceof AbsBaseEntity) {
                Field[] fields = args[0].getClass().getDeclaredFields();
                Field field = hasField(fields, "created_by");
                if (field != null) {
                        field.setAccessible(true);
                        field.set(args[0], "zyxTaeyeon");
                        field.setAccessible(false);
                    }
                field = hasField(fields, "creation_date");
                if (field != null) {

                    field.setAccessible(true);
                    field.set(args[0], new Date());
                    field.setAccessible(false);
                }
                field = hasField(fields, "operation_id");
                if (field != null) {

                    field.setAccessible(true);
                    field.set(args[0], "1234567");
                    field.setAccessible(false);
                }
            }
            return pjp.proceed(args);
        } else {
            return pjp.proceed();
        }

    }

    public Object doAroundForUpdate(ProceedingJoinPoint pjp) throws Throwable {
        Object args[] = pjp.getArgs();
        if (args.length >= 1) {

            Field[] fields = args[0].getClass().getDeclaredFields();
            Field field = hasField(fields, "last_updated_by");
            SysUser user = new SysUser();
            user.setName("JayChow");
            user.setAccount_enabled("T");
            user.setAccount_locked("F");

            if (field != null && user != null) {
                field.setAccessible(true);
                field.set(args[0],"Elva");
                field.setAccessible(false);
            }
            field = hasField(fields, "last_update_date");
            if (field != null) {

                field.setAccessible(true);
                field.set(args[0], new Date());
                field.setAccessible(false);
            }
            field = hasField(fields, "operation_id");
            if (field != null) {

                field.setAccessible(true);
                field.set(args[0], "1234567890");
                field.setAccessible(false);
            }
            return pjp.proceed(args);
        } else {
            return pjp.proceed();
        }
    }

    private Field hasField(Field[] fields, String fieldName) {
        for (Field f : fields) {
            if (fieldName.equals(f.getName())) {
                return f;
            }
        }
        return null;
    }

}

