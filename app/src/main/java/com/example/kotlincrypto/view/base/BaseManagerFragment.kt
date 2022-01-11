package com.example.kotlincrypto.view.base

import android.content.Intent

abstract class BaseManagerFragment:BaseTemplateFragment() {

 private val mManagers: MutableList<BaseManager> = ArrayList()

 open fun registerManager(manager: BaseManager) {
  mManagers.add(manager)
 }

 open fun unregisterManager(manager: BaseManager) {
  mManagers.remove(manager)
 }

 override fun onCreated() {
  super.onCreated()
  for (manager in mManagers) {
   manager.onCreated()
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
  while (iterator.hasNext()) {
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