package repository;

import model.IModel;

import java.util.List;

public abstract class FileContext<T> {
    protected Class<T> tClass;
    protected String filePath;
    private FileService fileService;

    public FileContext(FileService fileService) {
        this.fileService = fileService;
    }

    public FileContext() {
        fileService = new FileService();
    }

    public List<T> getAll(){
        return fileService.readData(filePath, tClass);
    }
    public T findById(long id){
        List<T> list = getAll();
        for (T item : list) {
            IModel<T> iModel = (IModel<T>) item;
            if (iModel.getId() == id) {
                return item;
            }
        }
        return null;
    }
    public void deleteById(long id){
        List<T> list = getAll();
        for (int i = 0; i < list.size(); i++) {
            IModel<T> iModel = (IModel<T>) list.get(i);
            if (iModel.getId() == id) {
                list.remove(i);
                break;
            }
        }
        fileService.writeDate(list, filePath);
    }

    public void add(T obj){
        List<T> list = getAll();
        list.add(obj);
        fileService.writeDate(list, filePath);
    }

    public void updateById(long id, T obj){
        List<T> list = getAll();
        for (T item : list) {
            IModel<T> iModel = (IModel<T>) item;
            if (iModel.getId() == id) {
                iModel.update(obj);
            }
        }
        fileService.writeDate(list, filePath);
    }
}
