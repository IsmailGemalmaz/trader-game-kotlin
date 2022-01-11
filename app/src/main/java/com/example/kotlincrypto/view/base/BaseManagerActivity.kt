package com.example.kotlincrypto.view.base

import android.content.Intent

abstract class BaseManagerActivity :BaseTemplateActivity(){
 private val mManagers: MutableList<BaseManager> = ArrayList()

 open fun registerManager(baseManager: BaseManager) {
  mManagers.add(baseManager)
 }

 open fun unregisterManager(baseManager: BaseManager) {
  mManagers.remove(baseManager)
 }

 override fun onCreated() {
  super.onCreated()
  for (manager in mManagers) {
   manager.onCreated()
   System.out.println("açıldı"+manager)
  }
 }

 override fun onStarted() {
  super.onStarted()
  for (manager in mManagers) {
   manager.onStarted()
  }
 }

 override fun onResumed() {
  super.onResumed()
  for (manager in mManagers) {
   manager.onResumed()
  }
 }

 override fun onLayoutReady() {
  super.onLayoutReady()
  for (manager in mManagers) {
   manager.onLayoutReady()
  }
 }

 override fun onPaused() {
  super.onPaused()
  for (manager in mManagers) {
   manager.onPaused()
  }
 }

 override fun onStopped() {
  super.onStopped()
  for (manager in mManagers) {
   manager.onStopped()
  }
 }

 override fun onDestroyed() {
  super.onDestroyed()
  val iterator = mManagers.iterator()
  while (iterator.hasNext()) {  //hasnext Hala dizide eleman varsa true döner değilse false döner
   val manager = iterator.next()
   manager.onDestroyed()
   manager.destroy()
   iterator.remove()
   // removeApiListener(manager);
  }
 }

 override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
  super.onActivityResult(requestCode, resultCode, data)
  for (manager in mManagers) {
   manager.onActivityResult(requestCode, resultCode, data)
  }
 }

 override fun onRequestPermissionsResult(
  requestCode: Int,
  permissions: Array<String?>,
  grantResults: IntArray
 ) {
  super.onRequestPermissionsResult(requestCode, permissions, grantResults)
  for (manager in mManagers) {
   manager.onRequestPermissionsResult(requestCode, permissions, grantResults)
  }
 }
}