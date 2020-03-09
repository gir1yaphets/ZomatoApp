package com.example.zomatoapp.manager;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;


public abstract class BaseDataManager<T extends RealmObject> {

    public static final String TAG = BaseDataManager.class.getSimpleName();

    private Realm initRealm() {
        return Realm.getDefaultInstance();
    }

    protected T update(T data) {
        Realm realmInstance = initRealm();
        T result = null;
        try {
            realmInstance.beginTransaction();
            result = realmInstance.copyFromRealm(realmInstance.copyToRealmOrUpdate(data));
            realmInstance.commitTransaction();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            realmInstance.close();
            return result;
        }
    }

    protected T updateObjectFromJson(Class<T> cls, String jsonData) {
        Realm realmInstance = initRealm();
        T result = null;
        try {
            realmInstance.beginTransaction();
            result = realmInstance.copyFromRealm(realmInstance.createOrUpdateObjectFromJson(cls, jsonData));
            realmInstance.commitTransaction();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            realmInstance.close();
            return result;
        }
    }


    protected void delete(Class<? extends RealmObject> clazz, String identifier, String type) {
        Realm realmInstance = initRealm();

        RealmObject dbResult;
        realmInstance.beginTransaction();
        try {
            dbResult = realmInstance.where(clazz).equalTo(type, identifier).findFirst();
            if (dbResult != null) {
                dbResult.deleteFromRealm();
            }
            realmInstance.commitTransaction();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            realmInstance.close();
        }
    }

    protected void deleteAll(final Class<? extends RealmObject> clazz) {
        Realm realmInstance = initRealm();

        try {
            realmInstance.beginTransaction();
            realmInstance.delete(clazz);
            realmInstance.commitTransaction();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            realmInstance.close();
        }
    }

    protected T query(Class<? extends RealmObject> clazz, String identifier, String type) {
        Realm realmInstance = initRealm();

        T result = null;
        RealmObject dbResult;
        try {
            dbResult = realmInstance.where(clazz).equalTo(type, identifier).findFirst();

            if(dbResult != null){
                result = (T) realmInstance.copyFromRealm(dbResult);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            realmInstance.close();
            return result;
        }
    }

    protected RealmObject retrieveFirst(Class<? extends RealmObject> clazz) {
        Realm realmInstance = initRealm();

        RealmObject result = null;
        try {
            RealmObject realmResult = realmInstance.where(clazz).findFirst();
            result = realmInstance.copyFromRealm(realmResult);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            realmInstance.close();
            return result;
        }
    }

    protected List<? extends RealmObject> retrieveAll(Class<? extends RealmObject> clazz) {
        Realm realmInstance = initRealm();

        List<? extends RealmObject> results = new ArrayList<>();
        try {
            RealmResults<? extends RealmObject> realmResults = realmInstance.where(clazz).findAll();
            results = realmInstance.copyFromRealm(realmResults);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            realmInstance.close();
            return results;
        }
    }

    protected long getCount(Class<? extends RealmObject> clazz) {
        Realm realmInstance = initRealm();

        long count = 0;
        try {
            count = realmInstance.where(clazz).count();
        } catch (Exception e) {
        } finally {
            realmInstance.close();
            return count;
        }
    }

    public abstract Object updateData(String signinID, Object responseData); // return converted dataModel

    public abstract void deleteAllData();

    public abstract long getCount();


}
