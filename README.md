# Memory  

**Data and file storage overview**  

Android uses a file system that's similar to disk-based file systems on other platforms. The system provides several options for you to save your app data:

App-specific storage: Store files that are meant for your app's use only, either in dedicated directories within an internal storage volume or different dedicated directories within external storage. Use the directories within internal storage to save sensitive information that other apps shouldn't access.   
- Shared storage: Store files that your app intends to share with other apps, including `media`, `documents`, and other files.
- Preferences: Store private, primitive data in key-value pairs.
- Databases: Store structured data in a private database using `SQLite` or the `Room` persistence library.  

**Access persistent files**  
Your app's ordinary, persistent files reside in a directory that you can access using the filesDir property of a context object.  
You can use the File API to access and store files:  
   ```java  
  File file = new File(context.getFilesDir(), filename);
  ```

**Store a file using a stream**
As an alternative to using the File API, you can call `openFileOutput()` to get a FileOutputStream that writes to a file within the filesDir directory.  

The following code snippet shows how to write some text to a file:  
  ```java  
  String filename = "myfile";
  String fileContents = "Hello world!";
  try (FileOutputStream fos = context.openFileOutput(filename, Context.MODE_PRIVATE)) {
      fos.write(fileContents.toByteArray());
  }
  ```


**Remove cache files**   
To remove a file from the cache directory within internal storage, use one of the following methods:

The `delete()` method on a File object that represents the file:  
   ```java     
   cacheFile.delete();
  ```
The `deleteFile()` method of the app's context, passing in the name of the file:  
  ```java  
context.deleteFile(cacheFileName);
```
